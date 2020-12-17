package secondSun.dominio;

import java.util.Date;

import secondSun.dominio.Persona;

public class Activacion {

	private static Integer contadorId = 0;

	private Integer id;
	private Persona personaQueActivoLaAlarma;
	private Date fechaYHoraActivacion;

	public Activacion(Persona personaQueActivoLaAlarma) {
		super();
		this.id = contadorId++;
		this.personaQueActivoLaAlarma = personaQueActivoLaAlarma;
		this.fechaYHoraActivacion = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activacion other = (Activacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Activacion comandada por: " + personaQueActivoLaAlarma + " - " + fechaYHoraActivacion+"\n";
	}

}

