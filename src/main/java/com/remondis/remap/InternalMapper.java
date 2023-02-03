package com.remondis.remap;

/**
 * This is an internal abstraction of the essential mapping function that is used internally by
 * {@link MappingConfiguration}. This
 * interface is used to generalize the mapper specified by {@link MappingConfiguration#useMapper(Mapper)} and the type
 * mapping
 * functions.
 */
interface InternalMapper<S, D> {

  /**
   * Performs the mapping from the source into a specified destination object. In case of a Java Bean mapper the fields
   * in the destination object are overridden if affected by the mapping configuration. In case of a custom type mapper,
   * the mapping function defines the behaviour.
   *
   * @param source The source object.
   * @param destination The destination object to map into.
   * @return Returns the specified destination object.
   */
  D map(S source, D destination);

  /**
   * Performs the mapping from the source into a specified destination object while overwriting fields in the
   * destination object if affected by the mapping configuration.
   *
   * @param source The source object to map to a new destination object.
   * @param destination The destination object to map into. Field affected by the mapping will be overwritten.
   * @param writeNullIfSourceIsNull Uses the corresponding configuration for all involved mapping configurations.
   * @return Returns the specified destination object.
   */
  D map(S source, D destination, boolean writeNullIfSourceIsNull);

  /**
   * Performs the mapping from the source into a new destination object. This method is expected to return a new
   * instance of the target object.
   *
   * @param source The source object.
   * @return Returns the specified destination object.
   */
  D map(S source);

  /**
   * Performs the mapping from the source to destination type.
   *
   * @param source The source object to map to a new destination object.
   * @param writeNullIfSourceIsNull Uses the corresponding configuration for all involved mapping configurations.
   * @return Returns a newly created destination object.
   */
  D map(S source, boolean writeNullIfSourceIsNull);

  /**
   * Returns the {@link Projection} this mapper defines.
   *
   * @return Returns the type projection information.
   */
  Projection<S, D> getProjection();

}
