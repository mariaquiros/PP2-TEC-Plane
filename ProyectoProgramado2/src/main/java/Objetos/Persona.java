package Objetos;
import org.json.JSONArray;

public class Persona {
	
	private String nombre,fechaN,pasaporte,nacionalidad,
				   lugarOrigen,lugarDestino,servicio,codigo,asiento;
	private String[] asientos= {"V","C","P"};
	private static int nTiquetes,nAsiento=0;
	
	/**
	 * 
	 * @param nombre
	 * @param fechaN
	 * @param pasaporte
	 * @param nacionalidad
	 * @param lugarOrigen
	 * @param lugarDestino
	 * @param servicio
	 */
	public Persona (String nombre, String fechaN, String pasaporte,
			String nacionalidad, String lugarOrigen, String lugarDestino, String servicio) {
		
		this.updateNTiquetes();
		this.nombre=nombre;
		this.fechaN=fechaN;
		this.pasaporte=pasaporte;
		this.nacionalidad=nacionalidad;
		this.lugarOrigen=lugarOrigen;
		this.lugarDestino=lugarDestino;
		this.servicio=servicio;
		
		this.updateAsiento();
		this.codigo=this.servicio.charAt(0)+this.asiento+Persona.nTiquetes;

	}
	
	private void updateAsiento() {
		if (nAsiento<asientos.length) {
			this.asiento=asientos[nAsiento];
			Persona.nAsiento++;
		}else {
			Persona.nAsiento=0;
			this.asiento=asientos[nAsiento];
			Persona.nAsiento++;

		}
	}
	
	private void updateNTiquetes() {
		if (Persona.nTiquetes<99) {
			Persona.nTiquetes++;
		}else {
			Persona.nTiquetes=0;
		}
	}
	
	public String toString() {
		String msg="";
		msg+="\nCodigo: "+this.codigo;
		msg+="\nNombre: "+this.nombre;
		msg+="\nLugar de destino: "+this.lugarDestino;
		
		return msg;
	}
	public String getServicio() {
		return this.servicio;
	}
	public String getCodigo() {
		return this.codigo;
	}

}
