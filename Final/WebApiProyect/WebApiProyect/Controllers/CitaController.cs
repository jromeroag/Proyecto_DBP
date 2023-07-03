using Microsoft.AspNetCore.Mvc;

namespace WebAppliProyectoFinal.Controllers
{
    public class CitaController : Controller
    {
        [Route("Api/[Controller]")]
       
        public IActionResult Index()
        {
            return View();
        }
    }
}
