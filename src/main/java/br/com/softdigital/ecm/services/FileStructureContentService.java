package br.com.softdigital.ecm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softdigital.ecm.domains.FileStructureContent;
import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.dto.FileStructureContentDto;
import br.com.softdigital.ecm.repositories.FileStructureRepository;

@Service("content")
public class FileStructureContentService extends FileStructureService {

	@Autowired
	public FileStructureContentService(FileStructureRepository repository, FileStructureVersionService versionService) {
		super(repository, versionService);
	}

	public FileStructureDecorator fromDto(FileStructureContentDto objDto) {
		FileStructureDecorator obj = new FileStructureContent();
		
		obj.setId(objDto.getId());
		obj.setMandatoryVersionReview(obj.isMandatoryVersionReview());
		obj.setDocumentExpires(objDto.isDocumentExpires());
		obj.setNotify(objDto.isNotify());
		obj.setAllowsDownload(objDto.isAllowsDownload());
		obj.setValidateFrom(objDto.getValidateFrom());
		obj.setValidUntil(objDto.getValidUntil());
		obj.setVersionReview(objDto.getVersionReview());
		obj.setExpirationNotificationPeriod(objDto.getExpirationNotificationPeriod());
		obj.setDescription(objDto.getDescription());
		obj.setComments(objDto.getComments());
		obj.setKeyWords(objDto.getKeyWords());
		obj.setVersionDescription(objDto.getVersionDescription());
		obj.setMainContent(objDto.getMainContent());
		obj.setDocumentExpires(objDto.isDocumentExpires());

		if(objDto.getParentId() != null) {
			FileStructureDecorator parentId = findById(objDto.getParentId());
			obj.setParentId(parentId);
		}
		
		return obj;
	}

}
