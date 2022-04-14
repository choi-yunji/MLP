package org.multicampus.mlp.help.repository;

import java.util.List;

import org.multicampus.mlp.help.domain.HelpDto;



public interface HelpDao {
	List<HelpDto> getGuideList();
	HelpDto getGuideView(int id);
	void insert(HelpDto dto); //������ ���
	
	void updateHit(int id); // ��ȸ�� ���� 
	List<HelpDto> getHighLightList(HelpDto dto);
	
}
