package aplicacion.BancoM.usuarios;

public record CredencialesUsuario (
        String usuario,
        String contr
) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var creds = (CredencialesUsuario) o;
        return this.usuario.equals(creds.usuario()) && this.contr.equals(creds.contr());
    }
}
