package org.manuel.teambuilting.core.model;

import java.io.Serializable;

/**
 * @author Manuel Doncel Martos
 * @since 05/08/2017.
 */
public interface IdDependentEntity<Id extends Serializable> {

    Id getId();

}

