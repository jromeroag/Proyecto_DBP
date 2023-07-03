using System;
using System.Collections.Generic;

namespace WebAppliProyectoFinal.Models;

public partial class Paciente
{
    public int Idpa { get; set; }

    public string? Nompa { get; set; }

    public string? Apepa { get; set; }

    public string? Corpa { get; set; }

    public int Dnipa { get; set; }

    public int Celpa { get; set; }

    public virtual ICollection<Citum> Cita { get; set; } = new List<Citum>();
}
