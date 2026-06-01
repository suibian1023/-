package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.GenshinRecommendWeapon;
import com.ruoyi.system.service.IGenshinRecommendWeaponService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/weapon")
public class GenshinRecommendWeaponController extends BaseController
{
    private String prefix = "system/weapon";

    @Autowired
    private IGenshinRecommendWeaponService genshinRecommendWeaponService;

    @RequiresPermissions("system:weapon:view")
    @GetMapping()
    public String weapon()
    {
        return prefix + "/weapon";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:weapon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        startPage();
        List<GenshinRecommendWeapon> list = genshinRecommendWeaponService.selectGenshinRecommendWeaponList(genshinRecommendWeapon);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:weapon:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        List<GenshinRecommendWeapon> list = genshinRecommendWeaponService.selectGenshinRecommendWeaponList(genshinRecommendWeapon);
        ExcelUtil<GenshinRecommendWeapon> util = new ExcelUtil<GenshinRecommendWeapon>(GenshinRecommendWeapon.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("system:weapon:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:weapon:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        return toAjax(genshinRecommendWeaponService.insertGenshinRecommendWeapon(genshinRecommendWeapon));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:weapon:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinRecommendWeapon genshinRecommendWeapon = genshinRecommendWeaponService.selectGenshinRecommendWeaponById(id);
        mmap.put("genshinRecommendWeapon", genshinRecommendWeapon);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:weapon:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        return toAjax(genshinRecommendWeaponService.updateGenshinRecommendWeapon(genshinRecommendWeapon));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:weapon:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinRecommendWeaponService.deleteGenshinRecommendWeaponByIds(ids));
    }
}
