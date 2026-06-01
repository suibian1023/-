package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.GenshinRecommendArtifact;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface IGenshinRecommendArtifactService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public GenshinRecommendArtifact selectGenshinRecommendArtifactById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param genshinRecommendArtifact 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GenshinRecommendArtifact> selectGenshinRecommendArtifactList(GenshinRecommendArtifact genshinRecommendArtifact);

    /**
     * 新增【请填写功能名称】
     * 
     * @param genshinRecommendArtifact 【请填写功能名称】
     * @return 结果
     */
    public int insertGenshinRecommendArtifact(GenshinRecommendArtifact genshinRecommendArtifact);

    /**
     * 修改【请填写功能名称】
     * 
     * @param genshinRecommendArtifact 【请填写功能名称】
     * @return 结果
     */
    public int updateGenshinRecommendArtifact(GenshinRecommendArtifact genshinRecommendArtifact);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteGenshinRecommendArtifactByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteGenshinRecommendArtifactById(Long id);
}
