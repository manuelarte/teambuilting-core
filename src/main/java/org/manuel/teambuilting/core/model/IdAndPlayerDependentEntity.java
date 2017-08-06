package org.manuel.teambuilting.core.model;

import java.io.Serializable;

/**
 * @author Manuel Doncel Martos
 * @since 05/08/2017.
 */
public interface IdAndPlayerDependentEntity<Id extends Serializable> extends IdDependentEntity<Id>, PlayerDependentEntity {

}
