package br.com.jkavdev.algaworks.compras.converter;

//@FacesConverter(forClass = Cidade.class)
//public class CidadeConverter implements Converter {

//	@Inject
//	private Cidades cidades;
//	
//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		Cidade retorno = null;
//		
//		if (value != null) {
//			retorno = this.cidades.porCodigo(new Long(value));
//		}
//
//		return retorno;
//	}
//
//	@Override
//	public String getAsString(FacesContext context, UIComponent component, Object value) {
//		if (value != null) {
//			Long codigo = ((Cidade) value).getCodigo();
//			String retorno = (codigo == null ? null : codigo.toString());
//			
//			return retorno;
//		}
//		
//		return "";
//	}

//}