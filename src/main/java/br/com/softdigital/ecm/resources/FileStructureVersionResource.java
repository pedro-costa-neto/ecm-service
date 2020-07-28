package br.com.softdigital.ecm.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdigital.ecm.dto.FileStructureSimpleDto;
import br.com.softdigital.ecm.services.FileStructureVersionService;

@CrossOrigin
@RestController
@RequestMapping("/v1/file/structure/version")
public class FileStructureVersionResource {

	@Autowired
	private FileStructureVersionService service;
	
	@GetMapping(path = "/{mainId}")
	public ResponseEntity<List<FileStructureSimpleDto>> listByParentId(@PathVariable String mainId) {
		List<FileStructureSimpleDto> list = service.findByMainId(mainId);
		return ResponseEntity.ok(list);
	}
}
