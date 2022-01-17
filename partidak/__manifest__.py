# -*- coding: utf-8 -*-
{
    'name': "Partidak",

    'summary': """
        Modulo para ver las partidas jugadas""",

    'description': """
        modulo para mosstrar las partidas jugadas por los empleados junto con sus 
        respectivos puntos
        """,

    'author': "Jaggy",
    'website': "http://localhost:8069",

    # Categories can be used to filter modules in modules listing
    # Check https://github.com/odoo/odoo/blob/14.0/odoo/addons/base/data/ir_module_category_data.xml
    # for the full list
    'category': 'Uncategorized',
    'version': '1.0',

    # any module necessary for this one to work correctly
    'depends': ['base'],

    # always loaded
    'data': [
        'security/partidak_security.xml',
        'security/ir.model.access.csv',
        'views/views.xml',
        'views/templates.xml',
    ],
    # only loaded in demonstration mode
    'demo': [
        'demo/demo.xml',
    ],
    #indicamos que es una aplicacion:
    'application': True,
    
}
