package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
<#--import io.swagger.annotations.ApiOperation;-->
<#--import org.apache.shiro.authz.annotation.Logical;-->
<#--import org.apache.shiro.authz.annotation.RequiresPermissions;-->
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
<#--import com.common.res.DataResult;-->
<#if restControllerStyle>
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * ${table.comment!} 接口控制器
 * @author ${author}
 * @since ${date}
 */
@Slf4j
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/<#if controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
 <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
 <#else>
public class ${table.controllerName} {
 </#if>

    @Resource
    private ${table.serviceName} ${table.serviceName?uncap_first};

    /**
     * 通过主键ID查询一个${table.comment!}
     * @param id 主键ID
     */
    @GetMapping("/selectOne")
<#--    @RequiresPermissions("sys:${table.entityName?uncap_first}:list")-->
<#--    @ApiOperation("${table.entityName}查询单个")-->
    public ${table.entityName} get${table.entityName}(@RequestParam("id") Long id) {
        ${table.entityName} ${table.entityName?uncap_first}One = ${table.entityName?uncap_first}Service.get${table.entityName}(id);
        return ${table.entityName?uncap_first}One;
    }

    /**
     * 查询全部${table.comment!}
     */
    @GetMapping("/listAll")
<#--    @RequiresPermissions("sys:${table.entityName?uncap_first}:list")-->
<#--    @ApiOperation("${table.entityName}查询全部")-->
    public List<${table.entityName}> getAll${table.entityName}() {
        List<${table.entityName}> ${table.entityName?uncap_first}List = ${table.entityName?uncap_first}Service.getAll${table.entityName}();
        return ${table.entityName?uncap_first}List;
    }

    /**
     * 新增${table.comment!}
     * @param ${table.entityName?uncap_first} ${package.Entity}.${entity}
     */
    @PostMapping("/add")
<#--    @RequiresPermissions("sys:${table.entityName?uncap_first}:add")-->
<#--    @ApiOperation("${table.entityName}新增")-->
    public Object add(@Valid @RequestBody ${table.entityName} ${table.entityName?uncap_first}) {
        ${table.entityName?uncap_first}Service.add(${table.entityName?uncap_first});
        return null;
    }

    /**
     * 更新${table.comment!}
     * @param  ${table.entityName?uncap_first} ${package.Entity}.${entity}
     */
    @PutMapping("/update")
<#--    @RequiresPermissions("sys:${table.entityName?uncap_first}:update")-->
<#--    @ApiOperation("${table.entityName}修改")-->
    public int update(@Valid @RequestBody ${table.entityName} ${table.entityName?uncap_first}) {
        int num = ${table.entityName?uncap_first}Service.modify(${table.entityName?uncap_first});
        return num;
    }

    /**
     * 通过主键ID删除${table.comment!}
     * @param ids 主键ID（可以多个英文逗号隔开）
     */
    @DeleteMapping(value = "/delete/{ids}")
<#--    @RequiresPermissions("sys:${table.entityName?uncap_first}:delete")-->
<#--    @ApiOperation("${table.entityName}删除(单个条目)")-->
    public Object remove(@NotBlank(message = "{required}") @PathVariable String ids) {
        ${table.entityName?uncap_first}Service.remove(ids);
        return null;
    }
}
</#if>
