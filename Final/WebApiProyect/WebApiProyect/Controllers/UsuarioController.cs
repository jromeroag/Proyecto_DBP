using Microsoft.AspNetCore.Mvc;
using WebApiProyect.Models;
using WebAppliProyectoFinal.Services;

namespace WebAppliProyectoFinal.Controllers
{
    [Route("Api/[Controller]")]
    [ApiController]
    public class UsuarioController : Controller
    {
        
        private readonly IUsuario _usuario;
        public UsuarioController(IUsuario usuario)
        {
            _usuario = usuario;
        }
        [HttpGet]
        public IActionResult Get()
        {
            return Ok(_usuario.GetAllUsuario());
        }
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult Principal()
        {
            return View();
        }
        public IActionResult Info()
        {
            return View();
        }

        public IActionResult validarUsuario(Usuario obj)
        {
            if (_usuario.ValidateUser(obj) == true)
            {
                return RedirectToAction("Index","Portada");
            }
            else
            {
                return View("Index");
            }

        }
        public IActionResult Nuevo()
        {
            return View();
        }
        public IActionResult Grabar(Usuario obj)
        {
            _usuario.add(obj);
            return RedirectToAction("Index");
        }



    }
}
