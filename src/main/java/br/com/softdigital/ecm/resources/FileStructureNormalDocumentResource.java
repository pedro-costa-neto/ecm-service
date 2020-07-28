package br.com.softdigital.ecm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdigital.ecm.domains.FileStructureDecorator;
import br.com.softdigital.ecm.dto.FileStructureNormalDocumentDto;
import br.com.softdigital.ecm.services.FileStructureNormalDocumentService;

@RestController
@RequestMapping("/v1/file/structure/document")
public class FileStructureNormalDocumentResource {
	
	@Autowired
	FileStructureNormalDocumentService service;
	
	@PostMapping(path = "/new")
	public ResponseEntity<FileStructureDecorator> createDocument(@RequestBody FileStructureNormalDocumentDto documentDto) {
		service.save(service.fromDto(documentDto));
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<FileStructureDecorator> createDocument(
				@RequestBody FileStructureNormalDocumentDto documentDto,
				@PathVariable String id) {
		documentDto.setId(id);
		service.update(service.fromDto(documentDto));
		return ResponseEntity.noContent().build();
	}
}
