using System;
using System.Collections.Generic;

namespace WebAppliProyectoFinal.Models;

public partial class Doctor
{
    public int Iddoc { get; set; }

    public string? Nomdoc { get; set; }

    public string? Apedoc { get; set; }

    public string? Espdoc { get; set; }

    public int Celdoc { get; set; }

    public virtual ICollection<Citum> Cita { get; set; } = new List<Citum>();
}
