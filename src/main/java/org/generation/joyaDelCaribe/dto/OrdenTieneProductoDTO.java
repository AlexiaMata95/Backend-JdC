package org.generation.joyaDelCaribe.dto;

public class OrdenTieneProductoDTO {
    private Long ordenId;
    private Long ordenUsuariosId;
    private Long productosId;
    private int cantidad;

    // Getters y setters
    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public Long getOrdenUsuariosId() {
        return ordenUsuariosId;
    }

    public void setOrdenUsuariosId(Long ordenUsuariosId) {
        this.ordenUsuariosId = ordenUsuariosId;
    }

    public Long getProductosId() {
        return productosId;
    }

    public void setProductosId(Long productosId) {
        this.productosId = productosId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
