package br.com.softdigital.ecm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.dto.FileStructureFolderDto;
import br.com.softdigital.ecm.services.FileStructureFolderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/v1/file/structure/folder")
@Api(description = "Manipulação de pastas")
public class FileStructureFolderResource {

	@Autowired
	FileStructureFolderService service;
	
	@PostMapping
	@ApiOperation(value = "Criação pasta")
	public ResponseEntity<FileStructureDecorator> createFolder(@RequestBody FileStructureFolderDto folderDto) {
		service.save(service.fromDto(folderDto));
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Alteração de pasta")
	public ResponseEntity<FileStructureDecorator> changeFolder(
				@RequestBody FileStructureFolderDto folderDto, 
				@PathVariable String id) {
		folderDto.setId(id);
		service.update(service.fromDto(folderDto));
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value = "Exclusão de pasta")
	public ResponseEntity<FileStructureDecorator> deleteFolder(@PathVariable String id) {	
		service.markAsDeleted(id);
		return ResponseEntity.noContent().build();
	}
}
