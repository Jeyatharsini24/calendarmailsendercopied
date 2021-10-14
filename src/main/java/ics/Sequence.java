package ics;

/**
 * Generates the sequence tag of ICalendar.
 *
 * <pre>
 *   SEQUENCE:111
 * </pre>
 */
public final class Sequence implements ICalComponent
{
  private String sequence;

  public Sequence(String sequence)
  {
    this.sequence = sequence;
  }

  @Override
  public String value()
  {
    return "SEQUENCE:".concat(sequence);
  }
}
