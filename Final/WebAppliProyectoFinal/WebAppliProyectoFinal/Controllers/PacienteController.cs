using Microsoft.AspNetCore.Mvc;
using WebAppliProyectoFinal.Models;
using WebAppliProyectoFinal.Services;

namespace WebAppliProyectoFinal.Controllers
{
    public class PacienteController : Controller
    {
        private readonly IPaciente _paciente;
        public PacienteController(IPaciente paciente)
        {
            _paciente = paciente;
        }
        public IActionResult Index()
        {
            return View(_paciente.GetAllPacientes());
        }
        [Route("Paciente/Eliminar/{Id}")]
        public IActionResult eliminar(int id) 
        {
            _paciente.remove(id);
            return RedirectToAction("Index");
        }
        public IActionResult nuevo()
        {
            return View();
        }
        public IActionResult grabar(Paciente paciente)
        {
            _paciente.add(paciente);
            return RedirectToAction("Doctor","Index");
        }
        [Route("Paciente/Edit/{Id}")]
        public IActionResult Edit(int id)
        {
            return View(_paciente.edit(id));
        }
        public IActionResult editPaciente(Paciente obj)
        {
            _paciente.EditDatails(obj);
            return RedirectToAction("Index");
        }



    }
}
