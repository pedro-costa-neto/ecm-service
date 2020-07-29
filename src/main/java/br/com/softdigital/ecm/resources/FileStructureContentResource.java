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
import br.com.softdigital.ecm.dto.FileStructureContentDto;
import br.com.softdigital.ecm.services.FileStructureContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/v1/file/structure/document/content")
@Api(description = "Manipulação de documento tipo conteúdo")
public class FileStructureContentResource {
	
	@Autowired
	FileStructureContentService service;

	@PostMapping
	@ApiOperation(value = "Criação de documento tipo conteúdo")
	public ResponseEntity<FileStructureDecorator> createDocument(@RequestBody FileStructureContentDto contentDto) {
		service.save(service.fromDto(contentDto));
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	@ApiOperation(value = "Alteração de documento tipo conteúdo")
	public ResponseEntity<FileStructureDecorator> changeDocument(
				@RequestBody FileStructureContentDto objDto,
				@PathVariable String id) {
		objDto.setId(id);
		service.update(service.fromDto(objDto));
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value = "Exclusão de documento tipo conteúdo")
	public ResponseEntity<FileStructureDecorator> deleteFolder(@PathVariable String id) {	
		service.markAsDeleted(id);
		return ResponseEntity.noContent().build();
	}
}
