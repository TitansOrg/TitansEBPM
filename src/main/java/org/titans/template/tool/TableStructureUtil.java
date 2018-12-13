package org.titans.template.tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.titans.bean.template.ClassMemberBean;

public class TableStructureUtil {

    public static List<ClassMemberBean> getClassMembers(String tableName, ApplicationContext application) throws Exception {

        List<ClassMemberBean> members = new ArrayList<>();
        JdbcTemplate jdbc = application.getBean(JdbcTemplate.class);
        Connection con = jdbc.getDataSource().getConnection();
        String sql = "select col.colorder as colorder,"
                          + "col.name as colname,"
                          + "convert(varchar(200), ep.value) as coldesc,"
                          + "t.name as coltype,"
                          + "case when exists ("
                              + "select 1 "
                              + "from sysindexes si "
                              + "inner join sysindexkeys sik on si.id=sik.id and si.indid=sik.indid "
                              + "inner join syscolumns sc on sc.id=sik.id and sc.colid =sik.colid "
                              + "inner join sysobjects so on so.name=si.name and so.xtype='pk' "
                              + "where sc.id=col.id and sc.colid=col.colid "
                          + ") then '1' else '' end as isprimary "
                   + "from syscolumns col "
                   + "left join systypes t on col.xtype=t.xusertype "
                   + "inner join sysobjects obj on col.id=obj.id and obj.xtype='u' and obj.status>=0 "
                   + "left join sys.extended_properties ep on col.id=ep.major_id and col.colid=ep.minor_id and ep.name='ms_description' "
                   + "where obj.name=? "
                   + "order by col.colorder";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, tableName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {

            String colName = rs.getString("colname");
            String colType = rs.getString("coltype");
            String colDesc = rs.getString("coldesc");
            String isPrimary = rs.getString("isprimary");
            ClassMemberBean member = new ClassMemberBean();
            member.setMemberType(colType);
            member.setColumnName(colName);
            member.setDescription(colDesc);
            member.setIsPrimaryKey(isPrimary);
            members.add(member);
        }
        releaseDB(rs, pstmt, con);
        return members;
    }

    public static String getTableDesc(String tableName, ApplicationContext application) throws Exception {

        String tableDesc = "";
        String sql = "select convert(varchar(200), a.value) as tableDesc "
                   + "from sys.extended_properties a,"
                        + "sysobjects b "
                   + "where a.major_id=b.id "
                     + "and b.name=? "
                     + "and a.minor_id=0 "
                     + "and a.name='ms_description'";
        JdbcTemplate jdbc = application.getBean(JdbcTemplate.class);
        Connection con = jdbc.getDataSource().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, tableName);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {

            tableDesc = rs.getString("tableDesc");
        }
        releaseDB(rs, pstmt, con);
        return tableDesc;
    }

    public static void releaseDB(ResultSet resultSet, PreparedStatement pstmt, Connection connection) {

        if (resultSet != null) {

            try {

                resultSet.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        if (pstmt != null) {

            try {

                pstmt.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        if (connection != null) {

            try {

                connection.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}
