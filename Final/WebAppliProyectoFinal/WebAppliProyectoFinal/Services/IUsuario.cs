using WebAppliProyectoFinal.Models;

namespace WebAppliProyectoFinal.Services
{
    public interface IUsuario
    {
        bool ValidateUser(Usuario usuario);
        void add(Usuario obj);

    }
}
