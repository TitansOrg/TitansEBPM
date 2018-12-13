package org.titans.bean.template;

public class ClassMemberBean {

    /**
     * 成员类型.
     */
    private String memberType;

    /**
     * 成员名称.
     */
    private String memeberName = "";

    /**
     * 是否主键.
     */
    private String isPrimaryKey;

    /**
     * 列说明.
     */
    private String description;

    /**
     * 列名.
     */
    private String columnName;

    public String getMemberType() {

        return memberType;
    }

    public void setMemberType(String memberType) {

        if ("varchar".equals(memberType)) {

            this.memberType = "String";
        } else if ("text".equals(memberType)) {

            this.memberType = "String";
        } else if ("mediumtext".equals(memberType)) {

            this.memberType = "String";
        } else if ("longtext".equals(memberType)) {

            this.memberType = "String";
        } else if ("tinyint".equals(memberType)) {

            this.memberType = "Boolean";
        } else if ("bit".equals(memberType)) {

            this.memberType = "Boolean";
        } else if ("char".equals(memberType)) {

            this.memberType = "Boolean";
        } else if ("int".equals(memberType)) {

            this.memberType = "Integer";
        } else if ("smallint".equals(memberType)) {

            this.memberType = "Integer";
        } else if ("bigint".equals(memberType)) {

            this.memberType = "Long";
        } else if ("float".equals(memberType)) {

            this.memberType = "Float";
        } else if ("double".equals(memberType)) {

            this.memberType = "Double";
        } else if ("date".equals(memberType)) {

            this.memberType = "Date";
        } else if ("datetime".equals(memberType)) {

            this.memberType = "Date";
        } else if ("timestamp".equals(memberType)) {

            this.memberType = "Date";
        } else {

            this.memberType = "String";
        }
    }

    public String getMemeberName() {

        return memeberName;
    }

//    public void setMemeberName(String memeberName) {
//
//        this.memeberName = memeberName;
//    }

    public String getIsPrimaryKey() {

        return isPrimaryKey;
    }

    public void setIsPrimaryKey(String isPrimaryKey) {

        this.isPrimaryKey = isPrimaryKey;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getColumnName() {

        return columnName;
    }

    public void setColumnName(String columnName) {

        this.columnName = columnName;
        String[] names = columnName.split("_");
        for (int i = 0; i < names.length; i++) {

            if (i != 0) {

                memeberName = memeberName + names[i].substring(0, 1).toUpperCase() + names[i].substring(1);
            } else {

                memeberName = memeberName + names[i];
            }
        }
    }
}
