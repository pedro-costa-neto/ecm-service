package br.com.softdigital.ecm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileStructureFolderDto {
	private String id;
	protected String description;
	protected String parentId;
}
