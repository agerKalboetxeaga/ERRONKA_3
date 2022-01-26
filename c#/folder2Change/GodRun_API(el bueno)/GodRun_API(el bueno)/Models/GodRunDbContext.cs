
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Models
{
    public class GodRunDbContext : DbContext
    {
        public DbSet<Inkesta> Inkesta { get; set; }
    }
}
