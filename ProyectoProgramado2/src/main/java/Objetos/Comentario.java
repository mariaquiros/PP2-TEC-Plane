package Objetos;

import org.json.JSONArray;
import org.json.JSONException;

public class Comentario {
	
	private String usuario;
	private String comentario;
	private JSONArray sentimientos;
	
	public Comentario(String usuario,String comentario, JSONArray sentimientos) {
		this.usuario=usuario;
		this.comentario=comentario;
		this.sentimientos=sentimientos;
	}
	
	public String getUsuario () {
		return this.usuario;
	}
	
	public String getComentario () {
		return this.comentario;
	}
	
	public String getSentimientos() {
		String msg="";
		for (int i=0;i<sentimientos.length();i++) {
			try {
				msg+=sentimientos.getJSONObject(i).getString("feel")+" - ";
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}
	

}
