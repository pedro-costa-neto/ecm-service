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

@CrossOrigin
@RestController
@RequestMapping("/v1/file/structure/document/content")
public class FileStructureContentResource {
	
	@Autowired
	FileStructureContentService service;

	@PostMapping
	public ResponseEntity<FileStructureDecorator> createDocument(@RequestBody FileStructureContentDto contentDto) {
		service.save(service.fromDto(contentDto));
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<FileStructureDecorator> createDocument(
				@RequestBody FileStructureContentDto objDto,
				@PathVariable String id) {
		objDto.setId(id);
		service.update(service.fromDto(objDto));
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<FileStructureDecorator> deleteFolder(@PathVariable String id) {	
		service.markAsDeleted(id);
		return ResponseEntity.noContent().build();
	}
}
