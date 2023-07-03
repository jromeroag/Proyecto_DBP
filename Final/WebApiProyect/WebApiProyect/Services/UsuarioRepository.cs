using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using WebApiProyect.Controllers;
using WebApiProyect.Models;

namespace WebAppliProyectoFinal.Services
{
    [Route("Api/[Controller]")]
    [ApiController]
    public class UsuarioRepository : IUsuario
    {
        private PROYECT conexion = new PROYECT();


        public IEnumerable<Usuario > GetAllUsuario()
        {
            return conexion.Usuarios;
        }

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

        public IEnumerable<Usuario> GetUsuarios()
        {
            return conexion.Usuarios;
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
