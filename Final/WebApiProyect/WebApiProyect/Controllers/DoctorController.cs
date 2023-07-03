using Microsoft.AspNetCore.Mvc;
using WebApiProyect.Models;
using WebAppliProyectoFinal.Services;

namespace WebAppliProyectoFinal.Controllers
{
    [Route("Api/[Controller]")]
    [ApiController]
    public class DoctorController : Controller
    {
        private readonly IDoctor _doctor;
       
        public DoctorController(IDoctor doctor)
        {
            _doctor = doctor;
        }
        [HttpGet]
        public IActionResult Get()
        {
            return Ok(_doctor.GetAllDoctor());
        }
        [HttpDelete("Delete/{id}")]
        public IActionResult eliminar(int id)
        {
            _doctor.remove(id);
            return RedirectToAction("Index");
        }
        [HttpPost("Add")]
        public IActionResult nuevo()
        {
            return View();
        }
        public IActionResult grabar(Doctor doctor)
        {
            _doctor.add(doctor);
            return RedirectToAction("Index");
        }
        [Route("Doctor/Edit/{Id}")]
        public IActionResult Edit(int id)
        {
            return View(_doctor.edit(id));
        }
        public IActionResult editDoctor(Doctor obj)
        {
            _doctor.editaDetails(obj);
            return RedirectToAction("Index");
        }


    }
}
