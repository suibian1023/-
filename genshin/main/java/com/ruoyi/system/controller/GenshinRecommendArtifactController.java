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
import com.ruoyi.system.domain.GenshinRecommendArtifact;
import com.ruoyi.system.service.IGenshinRecommendArtifactService;
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
@RequestMapping("/system/artifact")
public class GenshinRecommendArtifactController extends BaseController
{
    private String prefix = "system/artifact";

    @Autowired
    private IGenshinRecommendArtifactService genshinRecommendArtifactService;

    @RequiresPermissions("system:artifact:view")
    @GetMapping()
    public String artifact()
    {
        return prefix + "/artifact";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:artifact:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        startPage();
        List<GenshinRecommendArtifact> list = genshinRecommendArtifactService.selectGenshinRecommendArtifactList(genshinRecommendArtifact);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:artifact:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        List<GenshinRecommendArtifact> list = genshinRecommendArtifactService.selectGenshinRecommendArtifactList(genshinRecommendArtifact);
        ExcelUtil<GenshinRecommendArtifact> util = new ExcelUtil<GenshinRecommendArtifact>(GenshinRecommendArtifact.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("system:artifact:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:artifact:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return toAjax(genshinRecommendArtifactService.insertGenshinRecommendArtifact(genshinRecommendArtifact));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:artifact:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinRecommendArtifact genshinRecommendArtifact = genshinRecommendArtifactService.selectGenshinRecommendArtifactById(id);
        mmap.put("genshinRecommendArtifact", genshinRecommendArtifact);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:artifact:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return toAjax(genshinRecommendArtifactService.updateGenshinRecommendArtifact(genshinRecommendArtifact));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:artifact:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinRecommendArtifactService.deleteGenshinRecommendArtifactByIds(ids));
    }
}
