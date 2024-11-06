### Configuración de la Categoría "General" y Reasignación al Borrar

* Para implementar la lógica de la categoría por defecto y la reasignación al eliminar una categoría, puedes manejarlo en
el servicio o repositorio correspondiente. Por ejemplo:

    -   Asignar "General" por defecto: En el método de creación de productos, verifica si la lista de categorías está vacía y
asigna la categoría "General" si es necesario.
    - Reasignación al borrar: Antes de eliminar una categoría, verifica si los productos asociados no tienen otras categorías.
Para esos productos, asigna la categoría "General".