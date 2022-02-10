using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Models
{
    /// <summary>
    /// This is the DB Context for our MS SQL Server Database
    /// </summary>
    public class GodRunDbContext : DbContext
    {
        public DbSet<Inkesta> Inkesta { get; set; }
        public DbSet<Comments> Comments { get; set; }

        public GodRunDbContext(DbContextOptions<GodRunDbContext> options) //sino peta
    : base(options)
        { }
    }
}
