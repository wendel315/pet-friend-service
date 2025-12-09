package org.math.almoxarifado.repository;

import org.math.almoxarifado.entity.ItemEstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemEstoqueRepository extends JpaRepository<ItemEstoqueEntity, String> {

    List<ItemEstoqueEntity> findByPedidoId(String pedidoId);

    List<ItemEstoqueEntity> findByStatus(ItemEstoqueEntity.StatusItem status);
}
