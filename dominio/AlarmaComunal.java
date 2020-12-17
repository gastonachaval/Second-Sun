package secondSun.dominio;

import java.util.HashSet;
import java.util.Iterator;

import secondSun.dominio.Persona;
import secondSun.dominio.Activacion;

public class AlarmaComunal {

	private final Double VALOR_DEL_BOTON = 45.0;
	private String nombre;
	private HashSet<Persona> usuariosRegistrados;
	private HashSet<Activacion> historialDeActivaciones;
	private Double caja;
	private Boolean estaSonando;

	public AlarmaComunal(String nombre) {
		this.nombre = nombre;
		this.usuariosRegistrados=new HashSet<Persona>();
		this.historialDeActivaciones=new HashSet<Activacion>();
		this.caja = 0.0;
		this.estaSonando=false;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean registrarUsuario(String nombreYApellido, Integer dni, String direccion, Long telefono) {
		return usuariosRegistrados.add(new Persona(nombreYApellido, dni, direccion, telefono));
	}

	public Boolean cobrarleAUnUsuario(Integer dni) {
		for (Iterator<Persona> iterator = usuariosRegistrados.iterator(); iterator.hasNext();) {
			Persona persona = (Persona) iterator.next();
			if (persona.getDni().equals(dni)) {
				Double pago = persona.abonarDinero(VALOR_DEL_BOTON);
				if (pago != 0) {
					caja += pago;
					return true;
				}
			}
		}
		return false;
	}

	public Persona getUsuario(Integer dniUsuarioABuscar) {
		for (Iterator<Persona> iterator = usuariosRegistrados.iterator(); iterator.hasNext();) {
			Persona persona = (Persona) iterator.next();
			if (persona.getDni().equals(dniUsuarioABuscar)) {
				return persona;
			}
		}
		return null;
	}
	
	public void hacerSonarAlarma() {
		estaSonando=!estaSonando;
	}

	public HashSet<Activacion> getHistorialDeActivaciones() {
		return historialDeActivaciones;
	}

	public void registrarActivacion(Persona usuarioQueActivoLaAlarma) {
		Activacion activacionARegistrar=new Activacion(usuarioQueActivoLaAlarma);
		historialDeActivaciones.add(activacionARegistrar);
		
	}

}
