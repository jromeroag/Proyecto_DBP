using Microsoft.AspNetCore.Mvc;
using System.Numerics;
using WebAppliProyectoFinal.Models;
using WebAppliProyectoFinal.Services;

namespace WebAppliProyectoFinal.Controllers
{
    public class DoctorController : Controller
    {
        private readonly IDoctor _doctor;

        public DoctorController(IDoctor doctor)
        {
            _doctor = doctor;
        }
        public IActionResult Index()
        {
            return View(_doctor.GetAllDoctor());
        }
        [Route("Doctor/Eliminar/{Id}")]
        public IActionResult eliminar(int id)
        {
            _doctor.remove(id);
            return RedirectToAction("Index");
        }
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
