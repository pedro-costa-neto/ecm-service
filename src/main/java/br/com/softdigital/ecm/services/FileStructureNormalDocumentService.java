package br.com.softdigital.ecm.services;

import java.math.BigDecimal;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.domains.FileStructureNormalDocument;
import br.com.softdigital.ecm.domains.enums.ControlIncrement;
import br.com.softdigital.ecm.dto.FileStructureNormalDocumentDto;
import br.com.softdigital.ecm.repositories.FileStructureRepository;

@Service("normal_document")
public class FileStructureNormalDocumentService extends FileStructureService {

	@Autowired
	public FileStructureNormalDocumentService(FileStructureRepository repository, FileStructureVersionService versionService) {
		super(repository, versionService);
	}

	public FileStructureDecorator fromDto(FileStructureNormalDocumentDto objDto) {
		FileStructureDecorator obj = new FileStructureNormalDocument();
		
		obj.setId(objDto.getId());
		obj.setMandatoryVersionReview(objDto.isMandatoryVersionReview());
		obj.setDocumentExpires(objDto.isDocumentExpires());
		obj.setNotify(objDto.isNotify());
		obj.setAllowsDownload(objDto.isAllowsDownload());
		obj.setValidateFrom(objDto.getValidateFrom());
		obj.setValidUntil(objDto.getValidUntil());
		obj.setExpirationNotificationPeriod(objDto.getExpirationNotificationPeriod());
		obj.setDescription(objDto.getDescription());
		obj.setComments(objDto.getComments());
		obj.setKeyWords(objDto.getKeyWords());
		obj.setVersionDescription(objDto.getVersionDescription());
		obj.setFileName(objDto.getFileName());
		obj.setFileExtension(objDto.getFileExtension());
		obj.setControlIncrement(ControlIncrement.VERSION);
		
		if(objDto.getParentId() != null) {
			FileStructureDecorator parentId = findById(objDto.getParentId());
			obj.setParentId(parentId);
		}
		
		byte[] mainFileByte = Base64.getDecoder().decode(objDto.getMainFile());
		obj.setMainFile(mainFileByte);
		
		BigDecimal fileSize = BigDecimal.valueOf(mainFileByte.length);
		fileSize = fileSize.divide(BigDecimal.valueOf(1024)); // Converte bytes para kilobytes
		fileSize = fileSize.divide(BigDecimal.valueOf(1024)); // Converte kilobytes para megabytes
		obj.setFileSize(fileSize);
		
		//versionReview;
		
		return obj;
	}

}
