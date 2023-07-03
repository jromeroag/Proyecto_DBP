using WebApiProyect.Models;

namespace WebAppliProyectoFinal.Services
{
    public interface IUsuario
    {
        IEnumerable<Usuario> GetAllUsuario();
        bool ValidateUser(Usuario usuario);
        void add(Usuario obj);

    }
}
