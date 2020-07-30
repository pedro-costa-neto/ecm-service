package br.com.softdigital.ecm.domains;

public class FileStructureContent extends FileStructureDecorator {
	private static final long serialVersionUID = 1L;

	public FileStructureContent() {
		this.documentType = 2;
	}
	
	@Override
	public Integer getDocumentType() {
		return this.documentType;
	}

}
