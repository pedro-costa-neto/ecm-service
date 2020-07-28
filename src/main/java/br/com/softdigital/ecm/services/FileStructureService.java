package br.com.softdigital.ecm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.domains.enums.ControlIncrement;
import br.com.softdigital.ecm.dto.FileStructureSimpleDto;
import br.com.softdigital.ecm.repositories.FileStructureRepository;

@Service
@Primary
public class FileStructureService {
	
	protected FileStructureRepository repository;
	protected FileStructureVersionService versionService;

	@Autowired
	public FileStructureService(FileStructureRepository repository, FileStructureVersionService versionService) {
		this.repository = repository;
		this.versionService = versionService;
	}
	
	public void save(FileStructureDecorator obj) {
		
		if(obj.getId() == null) {
			obj.setVersionReview(10000);
		}
		
		repository.save(obj);
	}
	
	public void update(FileStructureDecorator obj) {
		FileStructureDecorator newObj = findById(obj.getId());

		if(newObj.isMandatoryVersionReview() && obj.getControlIncrement().equals(null)) {
			// mensagem de erro quando o controle de versão/revisão é obrigatório e o controlIncrement for null
		}
				
		if(obj.getControlIncrement().equals(ControlIncrement.VERSION)) {
			versionService.save(newObj);
			int version = (int) (newObj.getVersionReview() / 9999);
			newObj.setVersionReview((version * 10000) + 10000);
		}
		else if(obj.getControlIncrement().equals(ControlIncrement.REVIEW)) {
			versionService.save(newObj);
			newObj.setVersionReview(newObj.getVersionReview() + 1);
		}
		else {
			newObj.setVersionReview(obj.getVersionReview());
		}
		
		newObj.setDocumentExpires(obj.isDocumentExpires());
		newObj.setNotify(obj.isNotify());
		newObj.setAllowsDownload(obj.isAllowsDownload());
		newObj.setMainFile(obj.getMainFile());
		newObj.setValidateFrom(obj.getValidateFrom());
		newObj.setValidUntil(obj.getValidUntil());
		newObj.setExpirationNotificationPeriod(obj.getExpirationNotificationPeriod());
		newObj.setFileSize(obj.getFileSize());
		newObj.setDescription(obj.getDescription());
		newObj.setComments(obj.getComments());
		newObj.setKeyWords(obj.getKeyWords());
		newObj.setVersionDescription(obj.getVersionDescription());
		newObj.setParentId(obj.getParentId());
		newObj.setFileExtension(obj.getFileExtension());
		newObj.setFileName(obj.getFileName());
		newObj.setMainContent(obj.getMainContent());
		
		save(newObj);
	}
	
	public void markAsDeleted(String id) {
		FileStructureDecorator obj = findById(id);
		obj.setTrash(true);
		save(obj);
	}
	
	public FileStructureDecorator findById(String id) {
		return repository.findById(id).get();
	}
	
	public List<FileStructureSimpleDto> findByParentId(String parentId) {
		return repository.findByParentId(parentId);
	}
	
	public List<FileStructureDecorator> findAll() {
		return repository.findAll();
	}
}
