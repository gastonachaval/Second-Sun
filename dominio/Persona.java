package secondSun.dominio;

public class Persona {
	private String nombreYApellido;
	private Integer dni;
	private String direccion;
	private Long telefono;
	private double billetera;

	public Persona(String nombreYApellido, Integer dni, String direccion, Long telefono) {
		super();
		this.nombreYApellido = nombreYApellido;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.billetera=800.0;
	}

	@Override
	public String toString() {
		return nombreYApellido + " - " + direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public Integer getDni() {
		return dni;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public Long getTelefono() {
		return telefono;
	}
	
	public Double abonarDinero(Double dineroAAbonar) {
		if (billetera>=dineroAAbonar) {
			billetera-=dineroAAbonar;
			return dineroAAbonar;
		}
		return 0.0;
		
	}

}