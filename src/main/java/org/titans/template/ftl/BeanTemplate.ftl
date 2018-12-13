package org.titans.bean.${module};

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ${tableDesc}.
 */
@Entity
@Table(name = "${tableName}")
public class ${className}Bean {

    <#list members as member>
    /**
     * ${member.description}.
     */
    private ${member.memberType} ${member.memeberName};

    </#list>
    <#list members as member>

    <#if member.isPrimaryKey == "1">
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    </#if>
    @Column(name = "${member.columnName}")
    public ${member.memberType} get${member.memeberName?cap_first}() {

        return ${member.memeberName};
    }

    public void set${member.memeberName?cap_first}(${member.memberType} ${member.memeberName}) {

        this.${member.memeberName} = ${member.memeberName};
    }
    </#list>
}
