package org.manuel.teambuilting.core.services.query;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @author manuel.doncel.martos
 * @since 5-4-2017
 */
public interface PlayerDependentQueryService<Entity> {

	/**
	 * Returns the entities that belong to the player desired
	 *
	 * @param playerId
	 * @return all the entities that belong to the player
	 */
	@SuppressWarnings("unused")
	Collection<Entity> findByPlayerId(BigInteger playerId);
}
