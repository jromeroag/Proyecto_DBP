using Microsoft.IdentityModel.Tokens;
using WebAppliProyectoFinal.Controllers;
using WebAppliProyectoFinal.Models;

namespace WebAppliProyectoFinal.Services
{
    public class UsuarioRepository : IUsuario
    {
        private PROYECT conexion = new PROYECT();

        public void add(Usuario obj)
        {
            
            try
            {
                conexion.Usuarios.Add(obj);
                conexion.SaveChanges();
            }
            catch (Exception e)
            {
                Console.WriteLine("Ocurrio un error al grabar los datos del Usuario!", e.Message);
            }
        }

        public bool ValidateUser(Usuario usuario)
        {
            var obj = (from tusu in conexion.Usuarios
                       where tusu.Nomusu == usuario.Nomusu
                       && tusu.Clausu == usuario.Clausu
                       select tusu).FirstOrDefault();
            if(obj == null)
            {
                return false;
            }
            else
            {
                return true;
            }

        }
    }
}
