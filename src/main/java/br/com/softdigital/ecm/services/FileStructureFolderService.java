package br.com.softdigital.ecm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.domains.FileStructureFolder;
import br.com.softdigital.ecm.dto.FileStructureFolderDto;
import br.com.softdigital.ecm.repositories.FileStructureRepository;

@Service("folder")
public class FileStructureFolderService extends FileStructureService {

	@Autowired
	public FileStructureFolderService(FileStructureRepository repository, FileStructureVersionService versionService) {
		super(repository, versionService);
	}

	public FileStructureDecorator fromDto(FileStructureFolderDto folderDto) {
		FileStructureDecorator folder = new FileStructureFolder();
		
		folder.setId(folderDto.getId());
		folder.setDescription(folderDto.getDescription());
		folder.setParentId(folderDto.getParentId());
		
		return folder;
	}

}
