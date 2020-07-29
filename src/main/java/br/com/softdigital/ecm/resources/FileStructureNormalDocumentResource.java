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
import br.com.softdigital.ecm.dto.FileStructureNormalDocumentDto;
import br.com.softdigital.ecm.services.FileStructureNormalDocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/v1/file/structure/document")
@Api(description = "Manipulação de documento tipo normal")
public class FileStructureNormalDocumentResource {
	
	@Autowired
	FileStructureNormalDocumentService service;
	
	@PostMapping
	@ApiOperation(value = "Criação de documento tipo normal")
	public ResponseEntity<FileStructureDecorator> createDocument(@RequestBody FileStructureNormalDocumentDto documentDto) {
		service.save(service.fromDto(documentDto));
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Alteração de documento tipo normal")
	public ResponseEntity<FileStructureDecorator> changeDocument(
				@RequestBody FileStructureNormalDocumentDto documentDto,
				@PathVariable String id) {
		documentDto.setId(id);
		service.update(service.fromDto(documentDto));
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value = "Exclusão de documento tipo normal")
	public ResponseEntity<FileStructureDecorator> deleteDocument(@PathVariable String id) {
		service.markAsDeleted(id);
		return ResponseEntity.noContent().build();
	}
}
