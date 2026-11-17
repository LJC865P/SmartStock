package smartstock;

import java.util.Scanner;

/**
 * SmartStock — Sistema de Gestión de Inventario para Tiendas y Supermercados.
 *
 * Proyecto Integrador de Estructuras de Datos.
 * Integrantes: Jose Perez · Nicolas Correa · Andres Lugo · Juan Sebastian Diaz Sanchez
 * Docente: Nathaly Diaz
 *
 * Clase principal que integra los 6 módulos mediante un menú interactivo.
 */
public class SmartStock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // =====================================================================
        // INICIALIZACIÓN DE ESTRUCTURAS DE DATOS (Módulos 1 al 6)
        // =====================================================================

        // Módulo 1 & 2: Arreglo lineal, búsquedas y ordenamientos
        InventarioLineal inventario = new InventarioLineal();

        // Módulo 3: Matrices 2D y 3D
        InventarioSucursales invSucursales = new InventarioSucursales();
        InventarioGeneral invGeneral = new InventarioGeneral();

        // Módulo 4: Listas enlazadas simple y doble
        ListaProductos listaSimple = new ListaProductos();
        ListaProductoDoble listaDoble = new ListaProductoDoble();

        // Módulo 5: Listas circulares (carrusel de promociones)
        ListaProductoCircular listaCircular = new ListaProductoCircular();
        ListaProductosCircularDoble carruselPromociones = new ListaProductosCircularDoble();

        // Módulo 6: Operaciones del supermercado
        PilaMovimientos pilaMovimientos = new PilaMovimientos();
        ColaClientes colaClientes = new ColaClientes();
        ColaPrioridadPedidos pedidosReposicion = new ColaPrioridadPedidos();
        CadenaProductos cadenaUtil = new CadenaProductos();

        // =====================================================================
        // CARGA DE DATOS INICIALES (Para demostración rápida)
        // =====================================================================
        Producto p1 = new Producto("Arroz Diana", 4500, 100);
        Producto p2 = new Producto("Frijoles Diana", 3800, 50);
        Producto p3 = new Producto("Leche Alpina", 5400, 30);
        Producto p4 = new Producto("Aceite de Girasol", 12000, 20);
        Producto p5 = new Producto("Azucar Rio Paila", 3000, 80);
        Producto p6 = new Producto("Sal Refisal", 1500, 60);

        // Registro en Inventario Lineal (Módulo 1)
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        inventario.agregarProducto(p6);

        // Registro en Listas Enlazadas (Módulo 4)
        listaSimple.insertarFinal(p1);
        listaSimple.insertarFinal(p2);
        listaSimple.insertarFinal(p3);
        listaSimple.insertarFinal(p4);

        listaDoble.insertarFinal(p1);
        listaDoble.insertarFinal(p2);
        listaDoble.insertarFinal(p3);

        // Registro en Carrusel Circular de Promociones (Módulo 5)
        listaCircular.insertarNodo(p1);
        listaCircular.insertarNodo(p2);
        listaCircular.insertarNodo(p3);

        carruselPromociones.insertarNodo(p1);
        carruselPromociones.insertarNodo(p3);
        carruselPromociones.insertarNodo(p4);
        carruselPromociones.insertarNodo(p6);

        // Registro en Inventario de Sucursales 2D (Módulo 3)
        // Bodega 0 = Norte, Bodega 1 = Centro, Bodega 2 = Sur
        invSucursales.registrarProductoSucursal(1, 0, 40); // Arroz en Bodega 0
        invSucursales.registrarProductoSucursal(1, 1, 35); // Arroz en Bodega 1
        invSucursales.registrarProductoSucursal(1, 2, 25); // Arroz en Bodega 2
        invSucursales.registrarProductoSucursal(2, 0, 20); // Frijoles en Bodega 0
        invSucursales.registrarProductoSucursal(2, 1, 15); // Frijoles en Bodega 1
        invSucursales.registrarProductoSucursal(2, 2, 15); // Frijoles en Bodega 2

        // Registro en Inventario General 3D (Módulo 3)
        invGeneral.registrarDatos(0, 0, p1); // Sucursal 0, Cat 0: Arroz
        invGeneral.registrarDatos(0, 1, p3); // Sucursal 0, Cat 1: Leche
        invGeneral.registrarDatos(1, 0, p2); // Sucursal 1, Cat 0: Frijoles

        // Precarga de Clientes en Cola (Módulo 6)
        colaClientes.encolarCliente("Carlos Gomez");
        colaClientes.encolarCliente("Maria Rodriguez");
        colaClientes.encolarCliente("Juan Martinez");

        // Precarga de Pedidos de Reposición con Prioridad (Módulo 6)
        pedidosReposicion.insertarPedido(p4.getId(), p4.getNombre(), 25, 1); // 1 = Urgente
        pedidosReposicion.insertarPedido(p3.getId(), p3.getNombre(), 40, 2); // 2 = Media
        pedidosReposicion.insertarPedido(p1.getId(), p1.getNombre(), 80, 3); // 3 = Normal

        // =====================================================================
        // CICLO PRINCIPAL — MENÚ INTERACTIVO
        // =====================================================================
        int opcion = -1;

        System.out.println("==========================================================");
        System.out.println("       S M A R T S T O C K   —   I N I C I A D O         ");
        System.out.println(" Sistema de Inventario basado en Estructuras de Datos    ");
        System.out.println("==========================================================");

        do {
            System.out.println("\n----------------- MENÚ PRINCIPAL -----------------");
            System.out.println(" 1. [M1/M2/M6] Buscar producto (Secuencial, Binaria, Texto)");
            System.out.println(" 2. [M1/M4/M6] Registrar entrada de producto (Stock / Pila)");
            System.out.println(" 3. [M1/M6]    Registrar venta (Atender cliente en caja)");
            System.out.println(" 4. [M6]       Deshacer último movimiento (Pila LIFO)");
            System.out.println(" 5. [M6]       Gestionar pedidos de reposición (Cola Prioridad)");
            System.out.println(" 6. [M3]       Reportes por sucursales y bodegas (Matriz 2D / 3D)");
            System.out.println(" 7. [M5]       Carrusel de promociones (Lista Circular Doble)");
            System.out.println(" 8. [M1/M4]    Ver inventarios completos (Arreglo, Lista Simple, Doble)");
            System.out.println(" 9. [M2]       Ordenar inventario (Burbuja, Inserción, Selección)");
            System.out.println(" 0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                String linea = scanner.nextLine();
                opcion = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println(">> Error: Debe ingresar un número entero válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    // Búsquedas
                    System.out.println("\n--- 1. BÚSQUEDA DE PRODUCTOS ---");
                    System.out.println("a. Búsqueda secuencial por ID");
                    System.out.println("b. Búsqueda binaria por ID");
                    System.out.println("c. Búsqueda por texto (CadenaProductos)");
                    System.out.print("Elija método (a/b/c): ");
                    String sub = scanner.nextLine().trim().toLowerCase();

                    if (sub.equals("a")) {
                        System.out.print("Ingrese ID a buscar: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        Producto prod = inventario.buscarSecuencial(id);
                        if (prod != null) {
                            System.out.println(">> Encontrado:");
                            prod.mostrarInformacion();
                        } else {
                            System.out.println(">> Producto no encontrado.");
                        }
                    } else if (sub.equals("b")) {
                        System.out.print("Ingrese ID a buscar: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        Producto prod = inventario.buscarBinaria(id);
                        if (prod != null) {
                            System.out.println(">> Encontrado con Búsqueda Binaria:");
                            prod.mostrarInformacion();
                        } else {
                            System.out.println(">> Producto no encontrado.");
                        }
                    } else if (sub.equals("c")) {
                        System.out.print("Ingrese palabra o fragmento a buscar: ");
                        String texto = scanner.nextLine().trim();
                        cadenaUtil.buscarTexto(texto, inventario.getProductos(), inventario.cantidadProductos());
                    } else {
                        System.out.println(">> Opción no válida.");
                    }
                    break;

                case 2:
                    // Registrar entrada
                    System.out.println("\n--- 2. REGISTRAR ENTRADA DE PRODUCTO ---");
                    System.out.print("Nombre del nuevo producto: ");
                    String nom = scanner.nextLine().trim();
                    System.out.print("Precio: ");
                    double pre = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Cantidad inicial en stock: ");
                    int cant = Integer.parseInt(scanner.nextLine().trim());

                    Producto nuevo = new Producto(nom, pre, cant);
                    inventario.agregarProducto(nuevo);
                    listaSimple.insertarFinal(nuevo);
                    listaDoble.insertarFinal(nuevo);
                    pilaMovimientos.apilarMovimiento(nuevo.getId(), "ENTRADA", cant);

                    System.out.println(">> Producto registrado en inventario lineal, listas enlazadas y apilado en historial.");
                    break;

                case 3:
                    // Registrar venta con Cola de Clientes
                    System.out.println("\n--- 3. REGISTRAR VENTA EN CAJA ---");
                    if (colaClientes.estaVacia()) {
                        System.out.print("No hay clientes en cola. Ingrese nombre del cliente: ");
                        String clienteNombre = scanner.nextLine().trim();
                        colaClientes.encolarCliente(clienteNombre);
                    }

                    System.out.println("Siguiente cliente en fila:");
                    Cliente cAtendido = colaClientes.desencolarCliente();

                    inventario.mostrarProductos();
                    System.out.print("Ingrese ID del producto a vender a " + cAtendido.getNombre() + ": ");
                    int idVenta = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Cantidad a vender: ");
                    int cantVenta = Integer.parseInt(scanner.nextLine().trim());

                    Producto pVenta = inventario.buscarSecuencial(idVenta);
                    if (pVenta != null && pVenta.getStock() >= cantVenta) {
                        pVenta.setStock(pVenta.getStock() - cantVenta);
                        pilaMovimientos.apilarMovimiento(idVenta, "VENTA", cantVenta);
                        System.out.println(">> Venta exitosa. Total: $" + (cantVenta * pVenta.getPrecio()));
                        System.out.println(">> Nuevo stock de " + pVenta.getNombre() + ": " + pVenta.getStock());
                    } else {
                        System.out.println(">> Error: Stock insuficiente o producto no encontrado.");
                    }
                    break;

                case 4:
                    // Deshacer movimiento con Pila LIFO
                    System.out.println("\n--- 4. DESHACER ÚLTIMO MOVIMIENTO (Pila LIFO) ---");
                    pilaMovimientos.mostrarPila();
                    System.out.print("¿Desea deshacer la última operación? (s/n): ");
                    String resp = scanner.nextLine().trim().toLowerCase();
                    if (resp.equals("s")) {
                        Movimiento mov = pilaMovimientos.desapilarMovimiento();
                        if (mov != null) {
                            Producto prodMod = inventario.buscarSecuencial(mov.getIdProducto());
                            if (prodMod != null) {
                                // Revertir efecto
                                if (mov.getTipo().equalsIgnoreCase("VENTA") || mov.getTipo().equalsIgnoreCase("SALIDA")) {
                                    prodMod.setStock(prodMod.getStock() + mov.getCantidad());
                                } else if (mov.getTipo().equalsIgnoreCase("ENTRADA")) {
                                    prodMod.setStock(Math.max(0, prodMod.getStock() - mov.getCantidad()));
                                }
                                System.out.println(">> Stock revertido exitosamente para: " + prodMod.getNombre());
                            }
                        }
                    }
                    break;

                case 5:
                    // Cola de prioridad de pedidos
                    System.out.println("\n--- 5. PEDIDOS DE REPOSICIÓN (Cola de Prioridad) ---");
                    pedidosReposicion.mostrarPedidos();
                    System.out.println("1. Despachar pedido más urgente");
                    System.out.println("2. Agregar nuevo pedido de reposición");
                    System.out.println("3. Volver");
                    System.out.print("Seleccione: ");
                    String opPed = scanner.nextLine().trim();

                    if (opPed.equals("1")) {
                        pedidosReposicion.atenderPedido();
                    } else if (opPed.equals("2")) {
                        System.out.print("ID del producto: ");
                        int idProd = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Nombre del producto: ");
                        String nomProd = scanner.nextLine().trim();
                        System.out.print("Cantidad a solicitar: ");
                        int cantP = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Prioridad (1 = Urgente, 2 = Media, 3 = Normal): ");
                        int prio = Integer.parseInt(scanner.nextLine().trim());

                        pedidosReposicion.insertarPedido(idProd, nomProd, cantP, prio);
                    }
                    break;

                case 6:
                    // Reportes por sucursales (Módulo 3)
                    System.out.println("\n--- 6. REPORTES POR SUCURSALES Y GENERAL ---");
                    System.out.println("a. Matriz 2D: Inventario por Bodegas");
                    System.out.println("b. Matriz 3D: Inventario General (Sucursal x Categoría x Producto)");
                    System.out.print("Elija reporte (a/b): ");
                    String r = scanner.nextLine().trim().toLowerCase();

                    if (r.equals("a")) {
                        invSucursales.recorrerMatriz(6);
                        System.out.println("Existencias de Producto 1 en Bodega 0: "
                                + invSucursales.consultarExistencias(1, 0) + " unidades.");
                    } else if (r.equals("b")) {
                        invGeneral.recorrerEstructura();
                    }
                    break;

                case 7:
                    // Carrusel de promociones (Módulo 5)
                    System.out.println("\n--- 7. CARRUSEL DE PROMOCIONES (Módulo 5) ---");
                    System.out.println("\n>> LISTA CIRCULAR SIMPLE (Recorrido Cíclico):");
                    listaCircular.recorrerCircular();

                    System.out.println("\n>> LISTA CIRCULAR DOBLE (Hacia adelante):");
                    carruselPromociones.recorrerAdelante();
                    System.out.println("\n>> LISTA CIRCULAR DOBLE (Hacia atrás):");
                    carruselPromociones.recorrerAtras();
                    break;

                case 8:
                    // Visualización de inventarios (Módulo 1 y 4)
                    System.out.println("\n--- 8. VISUALIZACIÓN DE ESTRUCTURAS ---");
                    System.out.println("\n>> ARREGLO UNIDIMENSIONAL (InventarioLineal):");
                    inventario.mostrarProductos();

                    System.out.println("\n>> LISTA SIMPLEMENTE ENLAZADA (ListaProductos):");
                    listaSimple.recorrerLista();

                    System.out.println("\n>> LISTA DOBLEMENTE ENLAZADA (ListaProductoDoble):");
                    listaDoble.recorrerAdelante();
                    break;

                case 9:
                    // Ordenamiento (Módulo 2)
                    System.out.println("\n--- 9. ALGORITMOS DE ORDENAMIENTO (Módulo 2) ---");
                    System.out.println("1. Ordenar por Nombre (Burbuja)");
                    System.out.println("2. Ordenar por ID (Inserción)");
                    System.out.println("3. Ordenar por Nombre (Selección)");
                    System.out.print("Seleccione: ");
                    String ord = scanner.nextLine().trim();

                    if (ord.equals("1")) {
                        inventario.ordenarBurbujaPorNombre();
                        System.out.println(">> Ordenado con Burbuja por Nombre:");
                        inventario.mostrarProductos();
                    } else if (ord.equals("2")) {
                        inventario.ordenarPorInsercion();
                        System.out.println(">> Ordenado con Inserción por ID:");
                        inventario.mostrarProductos();
                    } else if (ord.equals("3")) {
                        inventario.ordenarSeleccionPorNombre();
                        System.out.println(">> Ordenado con Selección por Nombre:");
                        inventario.mostrarProductos();
                    }
                    break;

                case 0:
                    System.out.println("\n==========================================================");
                    System.out.println(" Gracias por usar SmartStock. ¡Sistema finalizado!        ");
                    System.out.println("==========================================================");
                    break;

                default:
                    System.out.println(">> Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
