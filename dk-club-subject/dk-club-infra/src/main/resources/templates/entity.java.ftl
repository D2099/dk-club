package ${package.Entity};

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
* ${table.comment!}
* @author ${author}
* @date ${date}
*/
@Data
@Accessors(chain = true)
@TableName("${schemaName}${table.name}")
public class ${entity} implements Serializable {
    private static final long serialVersionUID = 1L;

<#list table.fields as field>
    <#if field.comment??>
    /**
    * ${field.comment}
    */
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
}
