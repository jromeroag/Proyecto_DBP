using Microsoft.AspNetCore.Mvc;
using WebAppliProyectoFinal.Models;
using WebAppliProyectoFinal.Services;

namespace WebAppliProyectoFinal.Controllers
{
    public class PortadaController : Controller
    {
         private readonly IPortada _portada;
        public PortadaController(IPortada portada)
        {
            _portada = portada;
        }
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult NueCar()
        {
            return View();
        }
        public IActionResult NueDer()
        {
            return View();
        }
        public IActionResult NuePed()
        {
            return View();
        }
        public IActionResult NueGine()
        {
            return View();
        }
        public IActionResult NueOnc()
        {
            return View();
        }
        public IActionResult NueOfta()
        {
            return View();
        }
        public IActionResult NueNeu()
        {
            return View();
        }
        public IActionResult NueMedGe()
        {
            return View();
        }
        public IActionResult Revisar()
        {
            return View();
        }
        public IActionResult Doctor()
        {
            return View();
        }

    }
}
