package br.com.softdigital.ecm.domains;

public class FileStructureNormalDocument extends FileStructureDecorator {
	private static final long serialVersionUID = 1L;

	public FileStructureNormalDocument() {
		this.documentType = 1;
	}
	
	@Override
	public Integer getDocumentType() {
		return this.documentType;
	}
	
}
