package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinRecommendArtifactMapper;
import com.ruoyi.system.domain.GenshinRecommendArtifact;
import com.ruoyi.system.service.IGenshinRecommendArtifactService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinRecommendArtifactServiceImpl implements IGenshinRecommendArtifactService 
{
    @Autowired
    private GenshinRecommendArtifactMapper genshinRecommendArtifactMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public GenshinRecommendArtifact selectGenshinRecommendArtifactById(Long id)
    {
        return genshinRecommendArtifactMapper.selectGenshinRecommendArtifactById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param genshinRecommendArtifact 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GenshinRecommendArtifact> selectGenshinRecommendArtifactList(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return genshinRecommendArtifactMapper.selectGenshinRecommendArtifactList(genshinRecommendArtifact);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param genshinRecommendArtifact 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGenshinRecommendArtifact(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return genshinRecommendArtifactMapper.insertGenshinRecommendArtifact(genshinRecommendArtifact);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param genshinRecommendArtifact 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGenshinRecommendArtifact(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return genshinRecommendArtifactMapper.updateGenshinRecommendArtifact(genshinRecommendArtifact);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGenshinRecommendArtifactByIds(String ids)
    {
        return genshinRecommendArtifactMapper.deleteGenshinRecommendArtifactByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGenshinRecommendArtifactById(Long id)
    {
        return genshinRecommendArtifactMapper.deleteGenshinRecommendArtifactById(id);
    }
}
