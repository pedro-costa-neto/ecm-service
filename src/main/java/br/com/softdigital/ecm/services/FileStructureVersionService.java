package br.com.softdigital.ecm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.domains.FileStructureVersion;
import br.com.softdigital.ecm.dto.FileStructureSimpleDto;
import br.com.softdigital.ecm.repositories.FileStructureVersionRepository;

@Service
public class FileStructureVersionService {
	
	private FileStructureVersionRepository repository;

	@Autowired
	public FileStructureVersionService(FileStructureVersionRepository repository) {
		this.repository = repository;
	}
	
	public void save(FileStructureDecorator obj) {
		FileStructureVersion objVersion = fromFileStructure(obj);
		repository.save(objVersion);
	}
	
	public List<FileStructureSimpleDto> findByMainId(String mainId) {
		return repository.findByMainId(mainId);
	}
	
	public FileStructureVersion fromFileStructure(FileStructureDecorator obj) {
		FileStructureVersion objVersion = new FileStructureVersion();
		
		objVersion.setId(null);
		objVersion.setMandatoryVersionReview(obj.isMandatoryVersionReview());
		objVersion.setDocumentExpires(obj.isDocumentExpires());
		objVersion.setNotify(obj.isNotify());
		objVersion.setAllowsDownload(obj.isAllowsDownload());
		objVersion.setTrash(obj.isTrash());
		objVersion.setMainFile(obj.getMainFile());
		objVersion.setValidateFrom(obj.getValidateFrom());
		objVersion.setValidUntil(obj.getValidUntil());
		objVersion.setVersionReview(obj.getVersionReview());
		objVersion.setExpirationNotificationPeriod(obj.getExpirationNotificationPeriod());
		objVersion.setFileSize(obj.getFileSize());
		objVersion.setDescription(obj.getDescription());
		objVersion.setComments(obj.getComments());
		objVersion.setKeyWords(obj.getKeyWords());
		objVersion.setVersionDescription(obj.getVersionDescription());
		objVersion.setParentId(obj.getParentId());
		objVersion.setFileExtension(obj.getFileExtension());
		objVersion.setFileName(obj.getFileName());
		objVersion.setMainContent(obj.getMainContent());
		objVersion.setDocumentType(obj.getDocumentType());
		objVersion.setMainId(obj);
		
		return objVersion;
	}
}
